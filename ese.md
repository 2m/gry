

```sh
> atz         # reset ELM chip
ELM327 v1.4b

> atd         # set all settings to defaults
OK

> atsp6       # select protocol 6
OK

> atcfc1      # can flow control on
OK

> stcsegr1    # turn CAN Rx segmentation on
OK

> stcsegt1    # turn CAN Tx segmentation on
OK

> atsh750     # set the header of transmitted OBD messages
OK

> atcra758    # set CAN hardware filter
OK

> atceaAE     # use CAN extended address hh
OK

> attaAE      # set tester address to hh
OK

> stcfcpc     # clear all flow control address pairs
OK

> stcfcpa 750 AE, 758 AE   # add flow control address pair
OK

> 222006      # protocol 6 message to check status of ESE (last number in response: 0 - ESE is off, 1 - ESE is on)
62 20 06 01 01

> 3E1         # protocol 6 message preparation
7F 3E 13

> 1003        # protocol 6 message preparation
50 03 00 32 01 F4

> 2E20060100  # protocol 6 message to turn off ESE
6E 20 06

> 2E20060101  # protocol 6 message to turn on ESE
6E 20 06
```
