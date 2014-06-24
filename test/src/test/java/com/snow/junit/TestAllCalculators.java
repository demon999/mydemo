package com.snow.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Administrator on 14-6-23.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TestCalculator.class,TestSquare.class})
public class TestAllCalculators {
}
