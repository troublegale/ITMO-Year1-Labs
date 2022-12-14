#!/usr/bin/bash

mkdir lab0 lab0_scripts
cd lab0_scripts

# file for step 1
cat << EOF > step1.sh
#!/usr/bin/bash

cd ~/lab0
touch darmanitan3 geodude6 hydreigon2
mkdir haunter7 minccino9 pidove3
cd haunter7
touch rattata
mkdir slaking squirtle
cd ~/lab0/minccino9
touch ponyta kingler squirtle
mkdir seismitoad
cd ~/lab0/pidove3
mkdir unfezant pichu pupitar buizel
cd ~/lab0

echo 'Тип диеты  Omnivore' > darmanitan3
echo 'Ходы  Ancientpower Block
Body Slam Counter Dynamicpunch Earth Power Fire Punch Iron Defense
Metronome Mud-Slap Rollout Seismic Toss Sleep Talk Snore Stealth Rock
Sucker Punch Superpower Thunderpunch' > geodude6
echo 'Тип диеты
Omnivore' > haunter7/rattata
echo 'Живет  Cave Mountain' > hydreigon2
echo 'Ходы  Body Slam
Bounce Heat Wave Iron Tail Low Kick Sleep Talk Snore Swift Quick
Attack' > minccino9/ponyta
echo 'Тип диеты  Carnivore' > minccino9/kingler
echo 'satk=5 sdef=6 spd=4' > minccino9/squirtle

echo step 1 done
EOF
echo step1.sh created

# file for step 2
cat << EOF > step2.sh
#!/usr/bin/bash

cd ~/lab0
chmod 404 darmanitan3
chmod 600 geodude6
chmod 512 haunter7
chmod 064 haunter7/rattata
chmod 736 haunter7/slaking
chmod 755 haunter7/squirtle
chmod 404 hydreigon2
chmod a+w minccino9
chmod 006 minccino9/ponyta
chmod 361 minccino9/seismitoad
chmod 046 minccino9/kingler
chmod 440 minccino9/squirtle
chmod 700 pidove3
chmod 513 pidove3/unfezant
chmod 333 pidove3/pichu
chmod 576 pidove3/pupitar
chmod 500 pidove3/buizel

echo step 2 done
EOF
echo step2.sh created

# file for step 3
cat << EOF > step3.sh
#!/usr/bin/bash

cd ~/lab0
ln -s ~/lab0/geodude6 minccino9/kinglergeodude
chmod +r minccino9/*
chmod +r geodude6
chmod +w pidove3/buizel
cp -a minccino9 pidove3/buizel
cat minccino9/kingler > darmanitan3_26
cat minccino9/ponyta >> darmanitan3_26
chmod -r minccino9/*
chmod -r geodude6
chmod -w pidove3/buizel
cp hydreigon2 haunter7/slaking
ln -s ~/lab0/minccino9 Copy_25
chmod +w haunter7
ln ~/lab0/darmanitan3 haunter7/rattatadarmanitan
chmod -w haunter7
cat darmanitan3 > minccino9/kinglerdarmanitan

echo step 3 done
EOF
echo step3.sh created

# file for step 4
cat << EOF > step4.sh
#!/usr/bin/bash

cd ~/lab0
mkdir tmp
wc -m s* */s* **/s* 2>~/lab0/tmp/err | sort
ls -ltr minccino9
cat darmanitan3 | sort -r | cat -n
grep -nE k$ minccino9/* 2>&1
ls -lu *pi* */*pi* */*/*pi* 2>>~/lab0/tmp/err | head -n 3 
grep -vi mni pidove3/* 2>/dev/null

echo step 4 done
EOF
echo step4.sh created

# file for step 5
cat << EOF > step5.sh
#!/usr/bin/bash

cd ~/lab0
rm geodude6
chmod +w minccino9/ponyta 
rm minccino9/ponyta
rm minccino9/kinglergeodu*
chmod +w haunter7 haunter7/rattatadarmanit*
rm haunter7/rattatadarmanit*
chmod -R +rw pidove3
rm -r pidove3

echo step 5 done
EOF
echo step5.sh created

chmod 700 step*

