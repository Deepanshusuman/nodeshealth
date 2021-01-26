Bps_to_MiBps() {
    awk '{ printf "%.2f MiB/s\n", $0 / 1024 / 1024 } END { if (NR == 0) { print "error" } }'
}

download_benchmark() {
    curl --max-time 10 -so /dev/null -w '%{speed_download}\n' "$@"
}

printf ''
download_benchmark -4 http://cachefly.cachefly.net/100mb.test |
    Bps_to_MiBps