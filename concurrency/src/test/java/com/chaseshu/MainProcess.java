package com.chaseshu;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class MainProcess {

    public static void main(String[] args) {

        ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();

    }
}
