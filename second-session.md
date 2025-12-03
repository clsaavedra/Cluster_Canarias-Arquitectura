Presentation
Model        -> Domain + Interface (ports)
Persistence  -> Infrastructure + (Algo de presentation)

```
    ---------
   /         \
  /           \
 /             \
|    Domain:    |
|    Factory+   |
|    Ports      |
 \             /
  \           /
   \         /
    --------- Infrastructure
```

Domain no depende de nadie

Applications

```
                        Infrastructure
                             |
    -------------------------|---------------------
   /                         |                     \
  /                          |                      \
 /                    +------------+                 \
| +--------------+    | +--------+ |  +-------------+ |
| | Presentation |<-->| | Domain |<-->| Persistence | |
| +--------------+    | +--------+ |  +-------------+ |
|                     +------------+                 /
 \                           |                      /
  \                          |                     /
   \                         |                    /
    -------------------------|-------------------
               Input         | Output
               Primary       | Secondary
               Drivers       | Driven
```
Application -> Domain <- Infrastructure
     ^                         |
     +-----------<-------------+

Domain cannot depends Infrastructure