obdlink:
  sudo rfcomm bind rfcomm0 00:04:3E:5F:04:2A

rejsacan:
  sudo rfcomm bind rfcomm1 0C:DC:7E:DD:AB:52

attach:
  sudo ldattach \
    --debug \
    --speed 38400 \
    --eightbits \
    --noparity \
    --onestopbit \
    --iflag -ICRNL,INLCR,-IXOFF \
    29 \
    /dev/rfcomm0

setup:
  sudo ip link set can0 down
  sudo ip link set can0 type can bitrate 500000
  sudo ip link set can0 up
