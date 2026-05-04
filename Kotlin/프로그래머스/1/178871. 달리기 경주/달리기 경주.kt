class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        val answer: Array<String> = players.copyOf()

        val name2idx = HashMap<String, Int>()
        val idx2name = HashMap<Int, String>()

        for (i in answer.indices) {
            name2idx[answer[i]] = i
            idx2name[i] = answer[i]
        }

        for (name1 in callings) {
            val idx1 = name2idx[name1]!!
            val idx2 = idx1 - 1
            val name2 = answer[idx2]

            answer[idx2] = name1
            answer[idx1] = name2

            name2idx[name1] = idx2
            name2idx[name2] = idx1

            idx2name[idx1] = name2
            idx2name[idx2] = name1
        }

        return answer
    }
}