#!/usr/bin/env bash

e="echo -e"
en="echo -en"

move () {
	$en "\033[$2;$1f"
}

mark () {
	$en "\033[7m"
}

unmark () {
	$en "\033[27m"
}

erase () {
	$en "\033[H\033[2J"
}

reset () {
	$en "\033c"
}

off () {
	$en "\033[?25l"
}

on () {
	$en "\033[?25h"
}

up () {
	$en "\033[A"
}

down () {
	$en "\033[B"
}

next () {
	$en "\033E"
}

prev () {
	$en "\033[5~"
}

save () {
	$en "\033[?1049h"
}

restore () {
	$en "\033[?1049l"
}

rel () {
	$en "\033[$1A"
}

stay () {
	$en $'\e7'
}

leave () {
	$en $'\e8'
}