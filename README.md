

## Problem

Suppose you have decided to build your own online selling platform known as Amazing.com. You
have multiple sellers and buyers registered with Amazing.com. It has open access for both buyers
and sellers. The sellers add the items to the catalog and once the buyers make a purchase from
the catalog, the corresponding item is removed from the catalog. For the sake of simplicity, you
may assume all the items are of a single type such as books or shoes. You listed some sellers as
“preferred”sellers who have donated you some money. The preferred sellers have been given a
priority order based on the amount they have donated you. When buyers make a purchase, they
would always be delivered an item listed by a seller who is higher in the priority order. For example
assume sellers s1 , s2 ,and s3 have listed their books in the catalog. Also assume the priority order
ass 1 > s 2 > s 3 (s 1 is most preferred). Now buyers have to first purchase all the items listed by s1
before making a purchase from other sellers. Further, consider a situation where a buyer is buying
from s2 after all the items listed by s1 exhausted. In the meantime s1 again adds some items to
the catalog. Once the current purchase from s2 completes, the next buyer must buy the item(s)
listed by s1 before buying from any other seller. You may assume that the priorities are unique
(no duplicates) and non-negative. In the starter code, the priorities are given as simple integers.
Assume the lower number to be of higher priority. Being a student you’re on a budget and can’t
afford expensive infrastructure. As a result, you have very limited space for the catalog. At any
time at most N items can be stored in the catalog. If the catalog is already full, then the sellers
need to wait for some buyers to buy items before they can add their product to the catalog. Also,
if the catalog is empty, then the buyers need to wait until a seller adds their items to the catalog.
Your task is to implement the Seller and Buyer classes using Java Threads.

## Hint

You can model this question as to the classical Producer-Consumer problem. The sellers are the
producers who produce items to the shared catalog and the buyers are the consumers who consume
items from the catalog. As you can guess, since the buyers always buy from the preferred sellers,
the catalog data-structure should be implemented using a Priority Queue. For the design of the
system, each of the sellers takes an item from the shared queue called inventory and put it in
the catalog. The buyers get (remove the item with the highest priority) items from the catalog.
As we are using multiple buyer and seller threads all the operations have to be thread-safe (i.e.,
properly synchronized using concurrency primitives such as lock and conditions). Remember the
thread-safe operation always happens on the shared resources. There are two shared resources in
this design, the inventory list (shared between multiple producers) and the catalog priority queue


(shared between producers and consumers). Any operation on these data structures should be
properly synchronized.


## Compilation and Testing

You can use the make file for compilation and running the code. To compile your code, use

```
make compile
```
To run the code, use

```
make run
```
To clean the class files, use

```
make clean
```
There is a sample test case given to you inside the tests/input.txt file. The tests/sampleout.txt
contains the expected output. You can also use the python script to check the correctness of your
file. Run the runtest.py file, and you would see whether your implementation passes the given
test case or not.

```
python3 runtest.py
```
