package com.li.统计代码行数;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Demo02 {


    public static void main(String[] args) throws Exception {
        Robot robot = new Robot();
        for (int i = 0; i < 50; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            Thread.sleep(100);


        }
    }
}
