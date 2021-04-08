# My First Personal Project

## **A Manhua Reading List Application**

A *manhua reading list application* is meant to keep track of a user's reading collection of manhuas. A manhua is a comic 
genre originated in China. The application can be used by users to keep record of any reading materials as desired, 
however I am targeting this application to track a list of manhuas, more specifically for an audience that reads 
translated manhuas. 

This project idea arose from the struggle that I have seen manhua readers like me encounter. This struggle is to 
keep track of the manhuas I read because these can be found on different online sources where other members of the 
community translate for free. Likewise, manhuas are released per chapter rather than complete, thus keeping track of 
which chapter I last read is easy to forget. Sometimes I even forget which manhuas I am reading from many. Thus, this 
project interests me because the more I find manhuas to read from numerous sources, the more difficult it is to keep 
track of my reading. Hence, I hope to solve my problem through this project for personal use, and I hope to help other 
readers in the same situation. 
 
## **User Stories**
My user stories:
-	As a user, I want to be able to add a manhua to my reading list
-	As a user, I want to be able to remove a manhua from my reading list
-	As a user, I want to be able to search for a manhua from my reading list
-	As a user, I want to be able to view all manhuas in my reading list 
-	As a user, I want to be able to save my manhua reading list to file 
-	As a user, I want to be able to load my manhua reading list from file 

## **Phase 4: Task 2**
Test and design the Manhua class in the model package to be robust. The Manhua constructor is the robust design.

## **Phase 4: Task 3**
-	Derive a Website class from the Manhua Class. The Manhua class has the website name as a field, but there isn't much
room for more functionality for this field, so creating a new class just for the website source would allow for this
field to have more functionality, while keeping the Manhua class with a single responsibility, which is to maintain the 
characteristics of a given manhua. Thus, doing this refactoring would result in the Manhua class calling on the Website
class in the constructor.
