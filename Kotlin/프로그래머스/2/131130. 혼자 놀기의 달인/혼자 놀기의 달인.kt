class Solution {
    fun solution(cards: IntArray): Int {
        val group = ArrayDeque<Int>()
        
        val visited = BooleanArray(cards.size)
        
        for(i in 0 until cards.size){
            if(visited[i]) continue
            
            visited[i] = true
            group.addLast(1)
            
            var next = cards[i]
            while(!visited[next-1]){
                visited[next-1] = true
                next = cards[next-1]
                group[group.size-1]++
            }
        }
        
        var size1 = -1
        var size2 = -1
        
        if(group.size == 1) return 0
        
        for(i in 0 until group.size){
            if(size1 < group[i]) {
                size2 = size1
                size1 = group[i]
            }
            else if(size2 < group[i]) size2 = group[i]
        }
        
        return size1 * size2
    }
}