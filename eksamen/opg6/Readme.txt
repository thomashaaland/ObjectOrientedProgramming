README

I oppgave 6 valgte jeg aa parallellisere slik at Terminal og Skattkiste
klassene staar for laasing. Dermed kan ikke forskjellige spillere
lese inn i terminal eller haandtere skattkister samtidig med andre.
Jeg implementerte countdown latch for aa unngaa at spillet ble avsluttet
foer alle traadene var ferdig.

Men, programflyten er rotete. Jeg vurderte aa lage en spiller monitor
som lot hver spiller fullfoere sin tur foer den aksepterte neste spiller.
Hadde jeg gjort det paa denne maaten vill det vaere mer spillbart, men
dratt mindre nytte av parallelitet, saa jeg endte opp med aa la det vaere.
