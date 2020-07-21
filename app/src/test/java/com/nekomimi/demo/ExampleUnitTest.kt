package com.nekomimi.demo

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
        int cards[52] = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
            14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
            25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35,
            36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46,
            47, 48, 49, 50, 51, 52,
        };
        int n = x;//洗牌次数

        for(0..n){
            shuffle(cards)
        }
    }

    fun shuffle(list1: List<String>, list2: List<String>){

    }
}

class Cell{
    String mContent;
    Color mColor;
    int mFontSize;
    double height;
    double width;
}

class Column{
    List<Cell> cells;
    ColumnType type;

}

class Table{
    List<Column> columns;
}