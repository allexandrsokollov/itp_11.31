package vsu.cs.sokolov;


import org.junit.Assert;

public class StringHandlerTest {

    @org.junit.Test
    public void findTheLongestSentence() {

        String[] testTexts = new String[] {
                "qwerty.qwerty-qwerty.qwerty",
                "qwerty-qwerty. qwerty . qwerty",
                "qwerty ! qwerty ? qwerty-qwerty.",
                "@ # $ % qwerty? wer-qwe-wre ! ! ! ! # 4-^",
                "qwer-qwer-qwer! ASDF-AF AF ? LKJ-KJ-fds.",
                "qwerty! qwerty-qwerty? ASDF-ASFf."
        };

        String[] expected = new String[] {
                "qwerty-qwerty",
                "qwerty-qwerty",
                "qwerty-qwerty",
                "wer-qwe-wre ",
                "qwer-qwer-qwer",
                "qwerty-qwerty"

        };

        for (int i = 0; i < testTexts.length; i++) {
            Assert.assertEquals(expected[i], StringHandler.findTheLongestSentence(testTexts[i]));
        }
    }
}