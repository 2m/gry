Turning off ESE:

```
> atsp6       # select protocol 6
OK

> ath1        # turn on ECU headers
OK

> atrv        # query voltage
13.9V

> atsh750     # set obd header
OK

> atcra758
OK

> atceaAE
OK

> attaAE
OK

> stcfcpc
OK

> stcfcpa 750 AE, 758 AE
OK

> 3E1
758 AE 7F3E13

> 1003
758 AE 5003003201F4

> 222006
758 AE 6220060101

> 2E20060100  # turn off ESE (2E20060101 to turn on)
758 AE 6E2006

> 222006
758 AE 6220060100
```
