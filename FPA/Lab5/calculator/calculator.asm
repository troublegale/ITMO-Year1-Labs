ORG 0x100

;;;;;;;;;;;;;;;;;;;;;;;;;

start: CALL main
JUMP start

;;;;;;;;;;;;;;;;;;;;;;;;;

ready_in:
IN 0x1D
AND ready_flag
BEQ ready_in
RET

input:
CALL ready_in
IN 0x1C
ST current
RET

save_current_to_previous:
LD current
ST previous
RET

mask: WORD 0xF

equ_route:
LD previous
CMP mask
BEQ number_or_equals
CMP minus
BMI number_or_equals
BPL oper_sign
RET
number_or_equals:
CALL equals_after_number_or_equals
RET
oper_sign:
CALL equals_after_sign
RET

equals_after_number_or_equals:
LD sign
BNE qanoe_have_sign
RET
qanoe_have_sign:
CALL calc_and_print
RET

equals_after_sign:
CALL calc_and_print
RET

route:
LD current
CMP minus
BMI num
CMP mask
BEQ equ
CALL sign_route
RET
num:
CALL num_route
RET
equ:
CALL equ_route
RET

ready_flag: WORD 0x40

plus: WORD 0xB
minus: WORD 0xA

current: WORD 0
sign: WORD 0

num_route:
LD previous
CMP #0x7F
BEQ nothing_or_equals
CMP mask
BEQ nothing_or_equals
CMP minus
BMI number
CALL number_after_sign
RET
nothing_or_equals:
CALL number_after_nothing_or_equals
RET
number:
CALL number_after_number
RET

number_after_sign:
CALL nullify_B
CALL shift
CALL output_B
RET

nullify_sign:
CLA
ST sign
RET

shift:
LD numberB3
BEQ now_shift
RET
now_shift:
LD numberB2
ST numberB3
LD numberB1
ST numberB2
LD current
ST numberB1
RET

sign_route:
LD sign
BEQ just_save_sign
LD previous
CMP minus
BPL just_save_sign
CALL calc_and_print
just_save_sign:
CALL save_sign
RET

number_after_nothing_or_equals:
CALL nullify_B
CALL nullify_sign
CALL shift
CALL output_B
CALL copy_B_to_A
RET

previous: WORD 0x7F

number_after_number:
CALL shift
CALL output_B
LD sign
BNE no_copying
CALL copy_B_to_A
no_copying: RET

ready_out:
IN 0x15
AND ready_flag
BEQ ready_out
RET

main:
CALL input
CALL route
CALL save_current_to_previous
RET
output_A:
CALL ready_out
LD numberA1
OUT 0x14
CALL ready_out
LD #0x10
ADD numberA2
OUT 0x14
CALL ready_out
LD #0x20
ADD numberA3
OUT 0x14
RET

save_sign:
LD current
ST sign
RET

output_B:
CALL ready_out
LD numberB1
OUT 0x14
CALL ready_out
LD #0x10
ADD numberB2
OUT 0x14
CALL ready_out
LD #0x20
ADD numberB3
OUT 0x14
RET

calculate:
LD sign
CMP plus
BEQ summa
CMP minus
BEQ divident
RET
summa:
CALL sum_func
RET
divident:
CALL sub_func
RET

numberB2: WORD 0

nullify_B:
CLA
ST numberB1
ST numberB2
ST numberB3
RET

too_big: WORD 0xA

calc_and_print:
CALL calculate
LD numberA3
CMP too_big
BMI ok
CALL reset
RET
ok:
CALL output_A
RET

numberB1: WORD 0
numberB3: WORD 0

carry: WORD 0

mask_or_equals: WORD 0xF

reset:
CALL ready_out
LD #0xA
OUT 0x14
CALL ready_out
LD #0xA
ADD #0x10
OUT 0x14
CALL ready_out
LD #0xA
ADD #0x20
OUT 0x14
CALL ready_out
LD #0x4C
OUT 0x14
CALL nullify_B
CALL nullify_sign
CALL copy_B_to_A
CALL clear_segments
RET

nullify_previous:
LD #0x7F
ST previous
RET

clear_segments:
CALL ready_out
LD #0xC
OUT 0x14
CALL ready_out
LD #0x1C
OUT 0x14
CALL ready_out
LD #0x2C
OUT 0x14
CALL ready_out
LD #0x3C
OUT 0x14
CALL ready_out
LD #0x4C
OUT 0x14
RET


sum_func:
CALL sum_part_1
CALL sum_part_2
CALL sum_part_3
RET

numberA1: WORD 0
numberA2: WORD 0
numberA3: WORD 0

copy_B_to_A:
LD numberB1
ST numberA1
LD numberB2
ST numberA2
LD numberB3
ST numberA3
RET

sum_part_1:
LD numberA1
ADD numberB1
CMP #0xA
BMI no_sum_correction_1
ADD #6
AND mask_or_equals
ST numberA1
LD #1
ST carry
RET
no_sum_correction_1:
ST numberA1
CLA
ST carry
RET

sum_part_2:
LD numberA2
ADD numberB2
ADD carry
CMP #0xA
BMI no_sum_correction_2
ADD #6
AND mask_or_equals
ST numberA2
LD #1
ST carry
RET
no_sum_correction_2:
ST numberA2
CLA
ST carry
RET

sum_part_3:
LD numberA3
ADD numberB3
ADD carry
ST numberA3
RET

sub_func:
CALL sub_part_1
CALL sub_part_2
CALL sub_part_3
RET

sub_part_1:
LD numberA1
SUB numberB1
BMI correction_1
ST numberA1
CLA
ST carry
RET
correction_1:
NEG
ST numberA1
LD #1
ST carry
RET

sub_part_2:
LD numberA2
SUB numberB2
SUB carry
BMI correction_2
ST numberA2
CLA
ST carry
RET
correction_2:
NEG
ST numberA2
LD #1
ST carry
RET

sub_part_3:
LD numberA3
SUB numberB3
SUB carry
BMI went_wrong
ST numberA3
RET
went_wrong:
LD #0xC
ST numberA3
RET
