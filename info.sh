Bps_to_MiBps() {
    awk '{ printf "%.2f MiB/s\n", $0 / 1024 / 1024 } END { if (NR == 0) { print "error" } }'
}

download_benchmark() {
    curl --max-time 10 -so /dev/null -w '%{speed_download}\n' "$@"
}
#echo "{"
echo '{"cpu":"'
printf $(top -b -n2 -p 1 | fgrep "Cpu(s)" | tail -1 | awk -F'id,' -v prefix="$prefix" '{ split($1, vs, ","); v=vs[length(vs)]; sub("%", "", v); printf "%s%.1f\n", prefix, 100 - v }')
echo '"'
#echo ","
echo ',"speed":'
printf '"'
download_benchmark -4 http://cachefly.cachefly.net/100mb.test |
    Bps_to_MiBps
echo '"'
echo "}"
