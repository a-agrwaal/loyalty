This is spring-boot application. requires Maven,Java 8 to build
How to build
(1) mvn clean install

How to execute(post build).
(1) go to target folder
(2) java -jar loyalty-0.0.1-SNAPSHOT.jar 

LoyaltyApplication.java is the main class.

Problem Statement
ABC India Private Limited needs some help in launching Loyalty Program for its customers. To start with
it plans to give away loyalty points to customers for purchases made at their stores based on the
following rules
1. New Customer that enrolls will get 100 Points as joining bonus.
2. Gold Class Customers (those who have made purchases > Rs 50,000 in the current calendar year)
get 25 points for every Rs 500/- spent.
3. Silver Class Customers (those that have made purchases > Rs 25,000 in the current calendar year)
get 2 points for every Rs 100/- spent.
4. All other enrolled customers will get points = 1% of total purchases made.
5. Customers who have not enrolled will not get any point.
At the end of every day, ABC India Pvt. limited gets a list of transactions done by various customers at
their stores (See table below). The following information is provided for each transaction: Name of the
Customer (optional), Email Address of the Customer (optional), Loyalty Card Number (Optional),
Purchase Amount, Date & Time of the purchase & Unique Transaction Id for the purchase.

Abhay,abhay@demo.com,11001,7402,22-06-2012 11:23,2348723
5000,22-06-2012 13:48,3830283
Anant,anant@example.com,11002,3839,22-06-2012 15:39,2939303
Ashish,ashish@mettl.com,11003,13890,22-06-2012 17:15,2828939
11001,12083,23-06-2012 11:38,3839403
Abhimanyu,abhi@mettl.com,11004,33283,23-06-2012 14:18,1384839
5984,23-06-2012 19:56,8383939
11003,38103,24-06-2012 15:38,9388383
Anant,anant@mettl.com,11002,7281,24-06-2012 19:18,2938381
1038,24-06-2012 20:00,8383383
Abhijeet,abhi@mettl.com,11005,17937,25-06-2012 18:53,3833838
