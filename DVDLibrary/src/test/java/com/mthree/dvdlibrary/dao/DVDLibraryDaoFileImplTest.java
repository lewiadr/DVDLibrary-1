/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mthree.dvdlibrary.dao;

import java.io.FileWriter;
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
public class DVDLibraryDaoFileImplTest
    {
    private DVDLibraryDao testDao;

    public DVDLibraryDaoFileImplTest()
        {
        }

    @BeforeAll
    public static void setUpClass()
        {
        }

    @AfterAll
    public static void tearDownClass()
        {
        }

    @BeforeEach
    public void setUp() throws Exception
        {
        String testFile = "testroster.txt";
        // Use the FileWriter to quickly blank the file
        new FileWriter(testFile);
        testDao = new DVDLibraryDaoFileImpl(testFile);
        }

    @AfterEach
    public void tearDown()
        {
        }

    @Test
    public void testSomeMethod()
        {
        fail("The test case is a prototype.");
        }

    }
