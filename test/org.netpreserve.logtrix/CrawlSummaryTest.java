package org.netpreserve.logtrix;

import org.checkerframework.checker.units.qual.Temperature;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

import static org.junit.Assert.*;

public class CrawlSummaryTest {

    @Test
    public void test() throws IOException {
        try (CrawlLogIterator log = new CrawlLogIterator(getClass().getResourceAsStream("crawl.log"))) {
            CrawlSummary summary = CrawlSummary.build(log);
            summary.print(System.out);
        }
    }

    @Test
    public void testRegisteredDomain() throws IOException {
        try (CrawlLogIterator log = new CrawlLogIterator(getClass().getResourceAsStream("crawl.log"))) {
            Map<String, CrawlSummary> summary = CrawlSummary.byRegisteredDomain(log);
            assertEquals(new HashSet(Arrays.asList("", "google-analytics.com", "nla.gov.au")), summary.keySet());
        }
    }

}