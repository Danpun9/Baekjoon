class Solution {
    data class WordInfo(val text: String, val start: Int, val end: Int)

    fun solution(message: String, spoiler_ranges: Array<IntArray>): Int {
        val words = mutableListOf<WordInfo>()

        // 단어 분리
        var startIdx = -1
        for (i in message.indices) {
            if (message[i] != ' ') {
                if (startIdx == -1) startIdx = i

                if (i == message.lastIndex || message[i + 1] == ' ') {
                    words.add(WordInfo(message.substring(startIdx, i + 1), startIdx, i))
                    startIdx = -1
                }
            }
        }

        // 스포 단어 분류
        val nonSpoilerWords = mutableSetOf<String>() // 공개 단어
        val spoilerWords = mutableListOf<String>() // 스포 단어

        for (word in words) {
            var isSpoiler = false
            for (range in spoiler_ranges) {
                val sStart = range[0]
                val sEnd = range[1]

                // 범위 내 스포 확인
                if (word.start <= sEnd && word.end >= sStart) {
                    isSpoiler = true
                    break
                }
            }

            if (isSpoiler) {
                spoilerWords.add(word.text)
            } else {
                nonSpoilerWords.add(word.text)
            }
        }

        // 중요 단어
        var answer = 0
        val revealedWords = mutableSetOf<String>() // 이전 공개 단어 (스포 단어지만, 앞에서 공개됨)

        for (wordText in spoilerWords) {
            // 공개 단어에 없음 & 이전 공개 단어에 없음
            if (!nonSpoilerWords.contains(wordText) && !revealedWords.contains(wordText)) {
                answer++
                revealedWords.add(wordText) // 카운트 후 공개
            }
        }

        return answer
    }
}