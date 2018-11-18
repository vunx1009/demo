package com.vunx1009.demo.utils

import android.util.Log
import com.vunx1009.demo.objects.Keyword
import junit.framework.Assert
import org.junit.Test
import java.util.stream.Collectors.toList

class KeywordUtilTest {

    @Test
    fun testParseKeyword() {
        val inputs = arrayOf("bánh trung thu", "harry potter", "tai nghe bluetooth", "đắc nhân tâm", "bánh trung thu kinh đô", "túi đeo chéo", "bình giữ nhiệt", "tai nghe");
        val expects = arrayOf("bánh\n trung thu", "harry\n potter", "tai nghe\n bluetooth", "đắc nhân\n tâm", "bánh trung\n thu kinh đô", "túi đeo\n chéo", "bình giữ\n nhiệt", "tai\n nghe");


        for (i in 0..inputs.size - 1) {
            val input = inputs.get(i)
            val expect = expects.get(i)
            val actual = KeywordUtil.parseKeyword(input);
            Assert.assertTrue(failParse(input, expect), expect.equals(actual))
        }
    }

    private fun failParse(input: String, actual : String): String {
        return String.format("parse failed: '%s' -> '%s'", input, actual)
    }

}