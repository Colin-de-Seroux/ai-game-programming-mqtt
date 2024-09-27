import sys
import time

for line in sys.stdin:
    line = line.strip()
    
    sys.stdout.write(str(time.time_ns()) + "\n")
    sys.stdout.flush()