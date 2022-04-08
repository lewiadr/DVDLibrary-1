/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mthree.dvdlibrary.dao;

import java.io.FileWriter;
import java.util.List;

import com.mthree.dvdlibrary.dto.DVD;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author westo
 */
public class DVDLibraryDaoFileImplTest {
    private DVDLibraryDao testDao;

    public DVDLibraryDaoFileImplTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() throws Exception {
        String testFile = "testroster.txt";
        // Use the FileWriter to quickly blank the file
        new FileWriter(testFile);
        testDao = new DVDLibraryDaoFileImpl(testFile);
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void testAddGetDVD() throws Exception {
        // Create our method test inputs
        String title = "Movie1";
        DVD dvd = new DVD(title);
        dvd.setUserRating("5/5");
        dvd.setStudio("Test");
        dvd.setRating("PG-13");
        dvd.setReleaseDate("2022");
        dvd.setDirectorName("Billy Bob");

        //  Add the student to the DAO
        testDao.addDVD(dvd);
        // Get the student from the DAO
        DVD retrievedStudent = testDao.getDVD(title);

        // Check the data is equal
        assertEquals(dvd.getTitle(),
                retrievedStudent.getTitle(),
                "Checking Movie Title.");
        assertEquals(dvd.getUserRating(),
                retrievedStudent.getUserRating(),
                "Checking Movie User Rating.");
        assertEquals(dvd.getStudio(),
                retrievedStudent.getStudio(),
                "Checking DVD studio.");
        assertEquals(dvd.getRating(),
                retrievedStudent.getRating(),
                "Checking DVD MPAA Rating.");
        assertEquals(dvd.getReleaseDate(),
                retrievedStudent.getReleaseDate(),
                "Checking DVD Release Date.");
        assertEquals(dvd.getDirectorName(),
                retrievedStudent.getDirectorName(),
                "Checking DVD Director's Name.");
    }

    @Test
    public void testAddGetAllDVDs() throws Exception {
        //Create first DVD
        DVD dvd1 = new DVD("Movie 1");
        dvd1.setUserRating("5/5");
        dvd1.setStudio("Test");
        dvd1.setRating("PG-13");
        dvd1.setReleaseDate("2022");
        dvd1.setDirectorName("Billy Bob");

        //Create 2nd DVD
        DVD dvd2 = new DVD("Movie 2");
        dvd2.setUserRating("Terrible");
        dvd2.setStudio("none");
        dvd2.setRating("PG-13");
        dvd2.setReleaseDate("2023");
        dvd2.setDirectorName("Joe");

        // Add both our DVDs to the DAO
        testDao.addDVD(dvd1);
        testDao.addDVD(dvd2);

        List<DVD> allDVDs = testDao.listDVDs();

        // First check the general contents of the list
        assertNotNull(allDVDs);
        assertEquals(2, allDVDs.size());

    }

    @Test
    public void testRemoveDVD() throws  Exception {
        String title = "Movie1";
        DVD dvd = new DVD(title);
        dvd.setUserRating("5/5");
        dvd.setStudio("Test");
        dvd.setRating("PG-13");
        dvd.setReleaseDate("2022");
        dvd.setDirectorName("Billy Bob");

        //  Add the student to the DAO
        testDao.addDVD(dvd);
        testDao.removeDVD(title);
        assertEquals(testDao.listDVDs().size(), 0, "Testing DVD Removal");
    }
}