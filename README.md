# T22_G03_Asst1

## Introduction of Group Members
    Name                SID
    Haolin Jin          510085113
    Xiaoqian Hu         500105263
    Yiheng Yang         510231499
    Zechao Sun          510048657

## introduction about how to run the project

    For this project, using gradle above 7.4 and using gradle build to build the project, and using gradle run to run the project.
    Our main class is 'App', we will use Gradle to compile and run this class, calling the main function in the App and 
    performing a series of operations.

## introduction about how to test the project
    
    We use jacoco to test the code which implemented by gralde, then store the test result in the build/reports/jacoco/test/html/default/index.html

## description of each class in the main package

    main class: 
        App -> used to call other classed to run the project.
    other classes: 
        User -> Super class of Admin and Normal User.
        Admin -> Have a list of all countries' exchange rates, and can view exchange rates, change exchange rates, 
                 add/delete countries' exchange rates, set the popular country.
        NormalUser -> Have a list of all countries' exchange rates, and can view exchange rates, make exchange.
        History -> Log every change Admin makes to the exchange rate.
        Rate -> It contains some parameters about the national exchange rate, such as the exchange rate between Australia 
                and other countries.
        UI -> By calling functions from other classes and using java.swing functions to implement user interface.

## reminders
    
    1. The exchange rate displayed in the project may not be the real time exchange rate and may be biased.
    2. Ui.java contains a small number of algorithmic functions such as Min and Max that implement the project functionality.
       These functions have been tested by JUnit. The rest of the UI functions are not tested by JUnit.
    3. Due to some reason, There is no commit to show on insight for Zechao Sun, but he actually do the whole Junit test
       and have some commits.
<img width="361" alt="屏幕截图 2023-07-27 012216" src="https://github.com/DokiHollin/CurrencyExchanger/assets/93866170/57d1f0ca-3360-4310-9247-40a8e3765827">
<img width="357" alt="屏幕截图 2023-07-27 012200" src="https://github.com/DokiHollin/CurrencyExchanger/assets/93866170/e15c4e66-d432-4005-978c-786b6ecfa131">
<img width="359" alt="屏幕截图 2023-07-27 012234" src="https://github.com/DokiHollin/CurrencyExchanger/assets/93866170/5855872b-3a04-4f97-81b6-a0cbe674d1ee">
