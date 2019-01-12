package com.techyourchance.unittestingfundamentals.exercise3;

import com.techyourchance.unittestingfundamentals.example3.Interval;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class IntervalsAdjacencyDetectorTest {
    IntervalsAdjacencyDetector SUT;

    @Before
    public void setUp() throws Exception {
        SUT = new IntervalsAdjacencyDetector();
    }

    // interval1 is before interval2
    @Test
    public void isAdjacent_interval1IsBeforeInverval2_false() throws Exception {
        Interval interval1 = new Interval(0, 3);
        Interval interval2 = new Interval(5, 8);
        boolean result = SUT.isAdjacent(interval1, interval2);
        assertThat(result, is(false));
    }

    // interval1 is before adjacent to interval2
    @Test
    public void isAdjacent_interval1IsBeforeAdjacentToInverval2_true() throws Exception {
        Interval interval1 = new Interval(0, 3);
        Interval interval2 = new Interval(3, 8);
        boolean result = SUT.isAdjacent(interval1, interval2);
        assertThat(result, is(true));
    }

    // interval1 is overlap to interval2 on start
    @Test
    public void isAdjacent_interval1OverlapsInverval2OnStart_false() throws Exception {
        Interval interval1 = new Interval(0, 3);
        Interval interval2 = new Interval(2, 8);
        boolean result = SUT.isAdjacent(interval1, interval2);
        assertThat(result, is(false));
    }

    // interval1 is overlap to interval2 on end
    @Test
    public void isAdjacent_interval1OverlapsInverval2OnEnd_false() throws Exception {
        Interval interval1 = new Interval(7, 13);
        Interval interval2 = new Interval(2, 8);
        boolean result = SUT.isAdjacent(interval1, interval2);
        assertThat(result, is(false));
    }

    // interval1 contains interval2
    @Test
    public void isAdjacent_interval1ContainsInverval2_false() throws Exception {
        Interval interval1 = new Interval(7, 13);
        Interval interval2 = new Interval(8, 12);
        boolean result = SUT.isAdjacent(interval1, interval2);
        assertThat(result, is(false));
    }

    // interval2 contains interval1
    @Test
    public void isAdjacent_interval1IsContainedWithinInverval2_false() throws Exception {
        Interval interval1 = new Interval(9, 10);
        Interval interval2 = new Interval(8, 12);
        boolean result = SUT.isAdjacent(interval1, interval2);
        assertThat(result, is(false));
    }

    // interval 1 is after adjacent to interval2
    @Test
    public void isAdjacent_interval1IsAfterAdjacentToInverval2_true() throws Exception {
        Interval interval1 = new Interval(9, 10);
        Interval interval2 = new Interval(7, 9);
        boolean result = SUT.isAdjacent(interval1, interval2);
        assertThat(result, is(true));
    }

    // interval 1 is after interval2
    @Test
    public void isAdjacent_interval1IsAfterInverval2_false() throws Exception {
        Interval interval1 = new Interval(9, 10);
        Interval interval2 = new Interval(5, 8);
        boolean result = SUT.isAdjacent(interval1, interval2);
        assertThat(result, is(false));
    }

    // interval1 is equal interval2
    @Test
    public void isAdjacent_interval1EqualsToInverval2_false() throws Exception {
        Interval interval1 = new Interval(9, 10);
        Interval interval2 = new Interval(9, 10);
        boolean result = SUT.isAdjacent(interval1, interval2);
        assertThat(result, is(false));
    }
}