#!/bin/sh

#function to find the nth fibonacci number
fiboNum() {
	if [ $1 -eq 1 -o $1 -eq 2 ]
	then
		echo 1
		return 
	fi
	echo $((`fiboNum $(($1 - 1))` + `fiboNum $(($1 - 2))`))
}

#function to print fibonacci sequence
listFibo() {
	echo -n "The fibonacci sequence is: "
	for ((i = 1; i <= $1; i++))
	do	
		echo -n "`fiboNum $i` "
	done
	echo	
}

#function to check whether a number is a fibonacci number
check() {
	result=0
	i=1
	while [ $result -le $1 ]
	do
		if [ $result -lt $1 ]
		then
			i=$(($i + 1))
			result=`fiboNum $i`
		else
			echo "$1 is a fibonacci number"
			return
		fi
	done
	echo "$1 is not a fibonacci number"
}

#start the program
while true
do
	clear
	echo "FIBONACCI SEQUENCE MANAGEMENT"
	echo "============================="
	echo "1) Find the nth fibonacci number."
	echo "2) Print a sequence of fibonacci number from 1 to nth."
	echo "3) Check whether a number is a fibonacci number or not."
	echo "4) Exit."

	echo -n "Choose an operation: "
	read choice

	case $choice in
		1)
			n1=0
			while [	$n1 -le 0 ]
			do
				echo -n "Input a positive integer: "
				read n1
			done
			echo "The $n1 th fibonacci number is: `fiboNum $n1`"
			echo "---[ENTER] to continue---"
			;;
		2)
			n2=0
			while [	$n2 -le 0 ]
			do
				echo -n "Input a positive integer: "
				read n2
			done
			listFibo $n2
			echo "---[ENTER] to continue---"
			;;
		3)
			n3=0
			while [	$n3 -le 0 ]
			do
				echo -n "Input a positive integer to check: "
				read n3
			done
			check $n3
			echo "---[ENTER] to continue---"
			;;
		4)
			echo Goodbye
			read
			clear
			exit 0
			;;
		*)
			echo "Invalid operation. [ENTER] to choose again."
			;;
	esac
	read
done		

exit 0