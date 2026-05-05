class Solution {
    var maxSheep = 0
    lateinit var tree: Array<MutableList<Int>>
    lateinit var isSheep: BooleanArray

    fun solution(info: IntArray, edges: Array<IntArray>): Int {
        isSheep = info.map { it == 0 }.toBooleanArray()
        tree = Array(info.size) { mutableListOf() }

        for (edge in edges) {
            val a = edge[0]
            val b = edge[1]
            tree[a].add(b)
        }
        
        maxSheep = 1 // 루트는 항상 양
        
        var initMask = 0
        for (child in tree[0])
            initMask = initMask or (1 shl child)

        dfs(1, 0, initMask)

        return maxSheep
    }

    fun dfs(sheep: Int, wolf: Int, currMask: Int) { // 현재 양, 현재 늑대, 갈 수 있는 후보 비트마스크
        maxSheep = maxOf(maxSheep, sheep)

        for (i in isSheep.indices) {
            if ((currMask and (1 shl i)) == 0) continue // 갈 수 없는 후보임

            val nextSheep = sheep + if (isSheep[i]) 1 else 0
            val nextWolf = wolf + if (!isSheep[i]) 1 else 0

            if (nextWolf >= nextSheep) continue // 조건에 걸리면, 이 노드로 가면 늑대가 많아짐

            var nextMask = currMask and (1 shl i).inv() // 현재 노드는 방문했으므로 후보에서 제외

            for (child in tree[i])
                nextMask = nextMask or (1 shl child)

            dfs(nextSheep, nextWolf, nextMask)
        }
    }
}