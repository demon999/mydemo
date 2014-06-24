package com.snow.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Administrator on 14-6-23.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TestWordDealUtil.class,TestWordDealUtilWithParam.class,TestAllCalculators.class})
public class TestSuiteRunAllUtil {
}
