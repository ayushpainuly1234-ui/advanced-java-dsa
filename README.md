# Advanced Java DSA

A topic-organised Java repository for data structures, graph algorithms, dynamic programming, trees, and backtracking. The goal is to make practice code easy to navigate and useful for dry runs and interview preparation.

## Explore by topic

| Topic | What you'll find |
|---|---|
| **[Graphs](graphs/README.md)** | BFS/DFS, cycle detection, shortest paths (Dijkstra and Bellman–Ford), spanning trees (Prim), topological ordering, articulation points, Kosaraju/Tarjan, and directed-graph exercises |
| **[Dynamic programming](dp/README.md)** | [DP problem roadmap](dp/DP_PROBLEM_ROADMAP.md) grouped by 1D/2D, string, knapsack/subset, tree, bitmask, interval, and optimisation patterns |
| **[Backtracking](backtracking/README.md)** | Permutations, maze/path search, N-Queens, and knight-move/grid-search exercises |
| **[Trees](trees/README.md)** | Traversals, tree construction and properties, path problems, transformations, BST operations, and LCA topics |

## Suggested interview-practice workflow

1. **State the problem and constraints.** Write down input size, edge cases, and what must be returned.
2. **Choose a pattern.** For example, BFS/DFS for traversal, Dijkstra for non-negative weighted shortest paths, or DP when overlapping subproblems and reusable state are present.
3. **Dry-run a small case.** Track the state, transitions, visited set, recursion stack, or DP table explicitly.
4. **Verify correctness.** Test an ordinary case, a boundary case, and a case where the initial intuition fails.
5. **Record complexity.** Explain time and auxiliary space in terms of the input size.
6. **Compile and run one standalone file at a time.** The repository is a collection of practice programs, not one Maven/Gradle application.

## Important scope note

This is a learning and interview-preparation repository. The DP roadmap is a reference list; it does **not** claim that every listed problem has been solved. Individual Java files should be reviewed and tested before using them as production-ready implementations. Existing exercise filenames are retained to keep the repository focused on discoverability rather than a broad rename.

## Related repository

For introductory Java exercises, arrays, strings, matrix problems, and programming fundamentals, see [Java DSA Practice](https://github.com/ayushpainuly1234-ui/java-dsa-practice).
