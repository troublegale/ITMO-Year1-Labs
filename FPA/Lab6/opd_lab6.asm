ORG 0x0

v0: WORD $default, 0x180
v1: WORD $default, 0x180
v2: WORD $int2, 0x180
v3: WORD $int3, 0x180
v4: WORD $default, 0x180
v5: WORD $default, 0x180
v6: WORD $default, 0x180
v7: WORD $default, 0x180
default: IRET

disable_redundant_int:
CLA
OUT 0x1
OUT 0x3
OUT 0xB
OUT 0xE
OUT 0x12
OUT 0x16
OUT 0x1A
OUT 0x1E
RET

enable_necessary_int:
LD #0xA
OUT 0x5
LD #0xB
OUT 0x7
RET

ORG 0x4C

x: WORD 20
x_addr: WORD 0x4C
max: WORD 21
min: WORD -22

start: 
DI
CALL disable_redundant_int
CALL enable_necessary_int
CLA
EI

main_loop:
LD x
PUSH
SUB #3
CALL AC_check
PUSH
PUSH
PUSH
PUSH
LD &3
ST &2
LD &4
ST &1
LD x_addr
ST &0
CALL compare_and_set
JUMP main_loop

AC_check:
CMP max
BMI min_check
JUMP correction
min_check:
CMP min
BPL check_passed
correction:
LD max
DEC
check_passed: RET

deref: WORD 0

compare_and_set:
PUSHF
DI
LD &2
ST deref
LD (deref)
CMP &3
BEQ then
JUMP exit
then:
LD &4
ST (deref)
exit:
POPF
SWAP
ST &3
POP
POP
POP
RET

int2:
PUSH
LD x
NOP
NOT
ST not_x
IN 0x4
AND not_x
CALL AC_check
ST x
NOP
POP
IRET

not_x: WORD 0

int3:
PUSH
LD x
NOP
ADD x
ADD x
ASL
ADD #4
NOP
OUT 0x6
POP
IRET