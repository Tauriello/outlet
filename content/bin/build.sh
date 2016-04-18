#!/usr/bin/env bash

name=auro
build=/build/classes/
source=/src/com/

e="echo -e"
en="echo -en"

width=$(tput cols)
height=$(tput lines)

divwid=$((width/2))
divhei=$((height/2))

l=4
s=1

name=(
	"a. Open"
	"b. Close"
	"c. Configure"
	"e. Exit"
)

title=(
	"Opening"
	"Closing"
	"Configuring"
	"Exit"
)

b1 () {
	$e "Java Log Open"
}

b2 () {
	$e "Java Log Close"
}

b3 () {
	$e "Options"
}

b4 () {
	exit
}

pos () {
	$en "\033[$2;$1f"
}

width () {
	pos $((divwid-($2/2))) $1
}

cent () {
	pos $((divwid-($1/2))) $(((divhei-($2/2))+$3))
}

clear () {
	$en "\033c"
}

mark () {
	$en "\033[7m"
}

unmark () {
	$en "\033[27m"
}

del () {
	$en "\033[J"
}

head () {
	width 1 25
	$e "Network Requisition Suite"
	
	width 2 9
	$e $1
}

foot () {
	pos 1 "$height"
	$en "Hit <Enter> to select option"
}

arrow () {
	read -sn3 c
	
	$e "okay"
	
	case "$c" in 
		$'\x1b\x5b\x41')
			de $s
			sel $((s-1))
		;;
		$'\x1b\x5b\x42')
			de $s
			sel $((s+1))
		;;
	esac
	
	if [[ -z $c ]]
	then
		clear
		head
		foot
		
		"b${s}"
 		
		page
	fi
}

page () {
	read -s
	init
}

sel () {
	s=$1

	if [[ $s -lt 1 ]]
	then
		s=$l
	fi
	
	if [[ $s -gt $l ]]
	then
		s=1
	fi
	
	mark
	cent 12 $l $s
	$en "${name[$s-1]}"
}

de () {
	unmark
	cent 12 $l $1
	$en "${name[$1-1]}"
}

menu () {
	o=1
	for b in "${name[@]}"
	do
		cent 12 $l $((o++))
		$en "$b"
	done
}

init () {
	clear
	del
	head "Main Menu"
	foot
	menu
	sel $s
}

init

while :
do
	arrow
done