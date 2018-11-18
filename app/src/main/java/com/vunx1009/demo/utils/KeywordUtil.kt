package com.vunx1009.demo.utils

import android.graphics.Color
import android.support.annotation.ColorInt
import java.util.*

class KeywordUtil {

    companion object {
        val KEYWORD_COLORS =
                listOf(Color.BLUE, Color.CYAN, Color.GRAY, Color.GREEN, Color.LTGRAY, Color.RED, Color.YELLOW)

        /**
         * If the keyword is more than one word, then display in two lines.
         * @param value: Keyword object
         * @return the keyword is formatted
         */
        fun parseKeyword(s: String): String {
            var wordCount = 0
            var indexCenter = 0;

            var word = false
            val endOfLine = s.length - 1
            for (i in 0 until s.length) {
                // if the char is a letter, word = true.
                if (Character.isLetter(s.get(i)) && i != endOfLine && !word) {
                    if ((s.length - i < indexCenter)) {
                        break
                    } else {
                        indexCenter = i - 1
                    }

                    word = true
                    // if char isn't a letter and there have been letters before,
                    // counter goes up.
                } else if (!Character.isLetter(s.get(i)) && word) {
                    wordCount++
                    word = false
                    // last word of String; if it doesn't end with a non letter, it
                    // wouldn't count without this.
                } else if (Character.isLetter(s.get(i)) && i == endOfLine) {
                    wordCount++
                }
            }
            if (wordCount <= 1) {
                return s;
            } else {
                return s.substring(0, indexCenter) + "\n" + s.substring(indexCenter)
            }
        }

        @ColorInt
        fun randomColor(): Int {
            val rand = Random();
            return KEYWORD_COLORS.get(rand.nextInt(KEYWORD_COLORS.size));
        }
    }
}