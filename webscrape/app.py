# Author: John Parkhurst
# Brief: Selenium Web Scraping application for hltv.org
from selenium.webdriver import *
from selenium.webdriver.common.by import By

from config import *
from selenium import webdriver
import re


class HltvScraper():


    #Looking for class result-con
    def gatherData(self) -> None:
        """
        @brief: Gathers the html content that we want from the page
        :return: None
        """
        resultData = login_form = self.driver.find_elements(by=By.CLASS_NAME,value="result-con")
        for element in resultData:
            temp = element.find_element(by=By.XPATH,value=".//a[@class='a-reset']/span[1]")
            print(temp.text)
            print("NEW MATCH")

        return

#Plan is to iterate through all the matches on said page and put into json of info to add to our api!


    def __init__(self):
        print("Scrape Initiated")
        self.driver = webdriver.Firefox()
        self.driver.get(url)
        try:
            self.gatherData()
        except:
            self.driver.close()
            print("ERROR")
            return
        self.driver.close()
        print("DONE")
