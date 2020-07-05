On my laptop, the brute force solution would take 3 minute 50 seconds with 100% CPU to finish the junit big input case. We want something better.

```
Using WindowPropertyNotReusable method:
simpleTestCase succeeded, time taken 1820496
simpleTestCase finished, time taken 1820496
bigInputCase succeeded, time taken 164468165
bigInputCase finished, time taken 164468165

Using BruteForce method:
simpleTestCase succeeded, time taken 1114337
simpleTestCase finished, time taken 1114337
bigInputCase succeeded, time taken 226925651427
bigInputCase finished, time taken 226925651427
```

- Runtime reduced to = (164468165 - 1820496) / (226925651427 - 1114337) ~= 0.0717%
- Improved speed by = (226925651427 - 1114337) / (164468165 - 1820496) ~= 1395 times faster
