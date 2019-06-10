# TwoSum
The problem definition stated that store would be called much less often than isSum.  For this reason, there are two implementations.  Precompute runs faster when the datastructure fits in memory, but it takes O(n^2) space.  The normal implementation only requires O(n) space, so it out performs once precompute hits memory problems.  Both use parallel streams to maximize performance.
