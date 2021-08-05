package com.interview;

public class Regex {

	public static void main(String[] args) {
		String regex="[^0-9_A-Z_a-z\\.]";
		String input = "@#My`$%--name@#$**is!!Manish**Paul.++My%%@@%Experience^#^is&##4.11**";
		System.out.println(input.replaceAll(regex, " ").replaceAll("[\s]+", "\s").replaceFirst("[\s]+", "") ) ;
	}

}
