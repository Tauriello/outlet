#!/usr/bin/env bash

source $(dirname $0)/suite.sh

e="echo -e"
en="echo -en"

u=$'\e[A'
d=$'\e[B'

h=24
w=80
y=6
x=9
l=4
r=11
s=1
p=0

ch=$((h/2))
cw=$((w/2))
cl=$((l/2))

cy=$(((y/2)-$cw))
cx=$(((x/2)-$cw))
cr=$(((r/2)-$cw))
ce=$(((l/2)-$ch))

title=(
	"Main Menu"
	"Sub Menu"
)

menu=(
	"a.Open"
	"b.Close"
	"c.Configure"
	"d.Exit"
)

head () {
	$en "Aurora"
}

foot () {
	$en "Press <Enter> to select option"
}

label () {
	$en ${title[0]}
}

accept () {
	mark
	$en $1
}

eject () {
	unmark
#	$en $1
}

raise () {
	$en "up"

	if [[ $p -lt $s ]]
	then
		p=3
		rel -3
	else
		((p--))
		accept $u
	fi
}

lower () {
	$en "down"

	if [[ $p -gt $l ]]
	then
		p=1
		rel 3
	else
		((p++))
		accept $d
	fi
}

interpret () {
	read c
	case "$c" in
		$u)
			$en "raise"
			raise
		;;
		$d)
			$en "lower"
			lower
		;;
	esac
}

list () {
	for a in ${menu[*]}
	do
		stay
		$en $a
		leave
		down
	done
}

default () {
	reset
	erase
	
	move $cy 1
	head
	
	move $cx 2
	label
	
	move 1 $h
	foot
}

init () {
	default

	move $cr $ce
	list
}

begin () {
	while :
	do
		interpret
	done
}

init &
begin &
wait