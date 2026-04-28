Algorithm Performance Analysis
Experiment Results Analysis
Analysis Questions Answers

1. Which sorting algorithm performed faster? Why?

Quick Sort performed significantly faster, especially on larger arrays.
Results:
- Size 10: Quick Sort ~0.6x faster (10,400 vs 6,300 ns) - slower on little datasets
- Size 100: Quick Sort ~5.98x faster on random data
- Size 1000: Quick Sort ~14.55x faster on random data
- Size 1000 sorted: Quick Sort ~26.22x faster

Why:
- Selection Sort (O(n²)): Always scans the entire unsorted portion to find minimum - many comparisons
- Quick Sort (O(n log n)): Divides array into smaller parts using divide-and-conquer - much fewer operations

2. How does performance change with input size?

Selection Sort performance degrades much faster than Quick Sort as size increases.

| Size |Selection Sort (Random)|Quick Sort(Random) |
| 10   | 6,300 ns              | 10,400 ns         |
| 100  | 98,200 ns (10x )      | 16,400 ns (5.9x ) |
| 1000 | 2,659,800 ns (280x )  | 182,800 ns(14.5x) |

Analysis:
- Selection Sort grows quadratically (n²) - very bad for large data
- Quick Sort grows log-linearly (n log n) - handles large data well

3. How does sorted vs unsorted data affect performance?

The effect is dramatically different for each algorithm.

Selection Sort:
- Sorted data actually performs better than random data
- Size 1000: Sorted (1,006,900 ns) vs Random (2,659,800 ns)
- Reason: Still does all comparisons, but fewer swaps (swaps only happen when finding minimum)

Quick Sort:
- Sorted data performs much better than random data
- Size 1000: Sorted (38,400 ns) vs Random (182,800 ns)
- Reason: middle pivot creates perfectly balanced partitions - optimal O(n log n) performance

4. Do the results match the expected Big-O complexity?
   Yes, the results qrowth patterns match theoretical complexity.

Expected vs Actual Performance Ratios:

Selection Sort O(n²):
- n=10 → 6,300 ns
- n=100 → predicted: 6,500 × (100²/10²) = 6,500 × 100 = 650,000 ns
- Actual: 98,200 ns - 10x less due to overhead, but matches growth pattern
- n=1000 → actual: 2,659,800 ns
- Expected growth: 10x size → 100x slower
- Actual 1000 vs 10: 2,659,800 / 6,300 - 422x slower

Quick Sort O(n log n):
- n=10 → 10,400 ns
- n=100 → actual: 16,400 ns (only 1.6x increase for 10x size)
- n=1000 → actual: 182,800 ns (17.6x increase for 100x size)

5. Which searching algorithm is more efficient? Why?
   Linear Search Performance:
   | Size | Search Time |
   | 10   | 900 ns      |
   | 100  | 1,600 ns    |
   | 1000 | 7,300 ns    |

Binary Search would be much more efficient:

| Array Size | Linear Search (max ops)| Binary Search          |
| 10         | 10 comparisons         | 4 comparisons          |
| 100        | 100 comparisons        | 7 comparisons          |
| 1000       | 1000 comparisons       | 10 comparisons         |

Why Binary Search is more efficient:
- Linear Search: O(n) - checks every element one by one
- Binary Search: O(log n) - eliminates half the array each step

6. Why does Binary Search require a sorted array?
   Binary Search relies on the ordered property of the array to make decisions.
   Explanation:
1. Divide and Conquer Logic:
    - Binary Search compares the target with the middle element
    - If target < middle - search left half
    - If target > middle - search right half
    - If equal  - found

2. Requirement for Order:
    - The algorithm assumes all elements in left half are less than middle
    - All elements in right half are greater than middle
    - This is only true if the array is sorted

Algorithm Performance Analysis: Sorting and Searching:

A. Project Overview:

Description of Selected Algorithms:

This project implements and compares three fundamental algorithms:

| Category         | Algorithm      |
| Basic Sorting    | Selection Sort |
| Advanced Sorting | Quick Sort     |
| Searching        | Linear Search  |

Purpose of the Experiment:
The experiment aims to:
1. Compare the actual performance of basic vs advanced sorting algorithms
2. Analyze how input size and data distribution affect algorithm efficiency
3. Verify theoretical time complexity with empirical measurements
4. Understand when to choose different algorithms for real-world applications

B. Algorithm Descriptions

1. Selection Sort (Basic Sorting):

How it works:
- Divides array into sorted and unsorted regions
- Repeatedly finds the minimum element from unsorted region
- Swaps it with the first element of unsorted region
- Expands sorted region by one element each iteration

Time Complexity:
O(n²) - always scans entire unsorted portion

2. Quick Sort (Advanced Sorting):

How it works:
- Uses divide-and-conquer strategy
- Selects a pivot element
- Partitions array so elements if < pivot go left, else if > pivot go right, else it is found
- Recursively sorts left and right subarrays

Time Complexity:
O(n log n) - perfectly balanced partitions

3. Linear Search:
   How it works:
- Sequentially checks each element in the array
- Compares each element with target value
- Returns index when found, -1 if not found

Time Complexity:
O(n)

C. Experimental Results:

Execution Times (in nanoseconds):

Random Arrays:

| Size | Selection Sort| Quick Sort |
| 10   | 6,300 ns      | 10,400 ns  |
| 100  | 98,200 ns     | 16,400 ns  |
| 1000 | 2,659,800 ns  | 182,800 ns |

Sorted Arrays:

| Size | Selection Sort| Quick Sort |
| 10   | 2,700 ns      | 2,800 ns   |
| 100  | 91,600 ns     | 14,900 ns  |
| 1000 | 1,006,900 ns  | 38,400 ns  |

Linear Search Results:

| Size | Time (ns)     |
| 10   | 900 ns        |
| 100  | 1600 ns       |
| 1000 | 7,300 ns      |

Performance Comparisons:
Quick Sort vs Selection Sort:

Array Size 10:     Selection Sort 6,300ns      Quick Sort 10,400ns (0,6x faster)
Array Size 100:    Selection Sort 98,200ns     Quick Sort 16,400ns (5.98x faster)
Array Size 1000:   Selection Sort 2,659,800ns  Quick Sort 182,800ns (14.55x faster)

Sorted vs Random Data:

Quick Sort performance:                              Selection Sort performance:
- Random (1000): 182,800 ns                          - Random (1000): 2,659,800 ns
- Sorted (1000): 38,400  ns                          - Sorted (1000): 1,006,900 ns
- Sorted arrays are 4.76x faster                     - Sorted arrays are 2,64x faster

D. Screenshots
Different Test Runs

| Run   | Selection Sort (1000) | Quick Sort (1000) |
| Run 1 | 1,824,600 ns          | 136,800 ns        |
| Run 2 | 1,792,300 ns          | 142,100 ns        |
| Run 3 | 2,659,800 ns          | 182,800 ns        |

Screenshots located in screenshots directory

E. Reflection Section

What I Learned About Algorithm Efficiency:

This experiment fundamentally changed my understanding of algorithm efficiency. Theory and reality don't always match at small scales.
For arrays of 10 elements, Selection Sort and Quick Sort performed nearly identically despite their vastly different Big-O complexities.
The overhead of recursive function calls in Quick Sort actually made it slightly slower for tiny datasets.
However, at n=1000 - Quick Sort completed in 136,800 ns while Selection Sort took 1,824,600 ns.
This 13x speedup perfectly demonstrates why O(n log n) vs O(n²) matters in real applications.
I also discovered that data distribution is crucial - Quick Sort with middle pivot performs 3x better on already sorted data.
This taught me that implementation details like pivot selection dramatically affect real-world performance.

Differences Between Theoretical and Practical Performance:

1. Small n anomalies: Theory predicts Quick Sort always faster for n>10, but actual results show Selection Sort wins for very small arrays due to less overhead
2. Cache locality: Selection Sort's sequential access pattern performed better than expected on small arrays

Challenges Faced During Implementation:

Challenge 1: Incorrect Quick Sort Implementation
Initially, my Quick Sort always picked the last element as pivot, causing O(n²) on sorted arrays.
The results showed Quick Sort actually slower than Selection Sort on sorted data!
After debugging, I discovered the pivot element wasn't being properly isolated during partitioning.
Switching to middle-pivot with proper swap logic fixed the issue.

Challenge 2: Accurate Performance Measurement
Single-run measurements were highly inconsistent.
I learned that it needed multiple iterations and average results

Challenge 3: Nanosecond Precision
Switching to System.nanoTime() provided microsecond-level precision needed for small array measurements.