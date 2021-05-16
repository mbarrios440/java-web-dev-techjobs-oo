package org.launchcode.techjobs_oo.Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job job1;
    Job job2;
    Job job3;
    Job job4;

    @Before
    public void createJobs(){
        job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job3 = new Job("Test Job", new Employer(""), new Location("Home"),
                new PositionType(""), new CoreCompetency("Test"));
        job4 = new Job();
    }

    @Test
    public void testSettingJobId(){
        assertNotEquals(job1.getId(), job2.getId());
        assertTrue(job2.getId() - job1.getId() == 1);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertEquals("Product tester",job1.getName());
        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality(){
        assertFalse(job1.equals(job2));
    }

    @Test
    public void toStringReturnsBlankLineBeforeAndAfter(){
        assertTrue(job1.toString().startsWith("\n") && job1.toString().endsWith("\n"));
    }

    @Test
    public void toStringReturnsLabelForEachFieldAndItsValue(){
        String jobString =
        "\nID: " + job1.getId() +
        "\nName: Product tester" +
        "\nEmployer: ACME" +
        "\nLocation: Desert" +
        "\nPosition Type: Quality control" +
        "\nCore Competency: Persistence\n";

        assertEquals(jobString,job1.toString());
    }

    @Test
    public void toStringReturnsDataNotAvailableIfFieldIsEmpty(){
        String jobString =
        "\nID: " + job3.getId() +
        "\nName: Test Job" +
        "\nEmployer: Data not available" +
        "\nLocation: Home" +
        "\nPosition Type: Data not available" +
        "\nCore Competency: Test\n";

        assertEquals(jobString,job3.toString());
    }

    @Test
    public void toStringReturnsMsgIfJobOnlyContainsDataForId() {
        String msg = "OOPS! This job does not seem to exist";

        assertEquals(msg, job4.toString());
    }

}
