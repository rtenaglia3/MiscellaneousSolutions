// Given a string s, return the longest in s.

// This first solution is functional but nonperformant, as it takes n^2 time.
// The algorithm is to crawl through each character and consider all substrings starting at that character
// Checks every string, hence being nonperformant
function solutionOne(s: string): string {
    let result: string = "";
    
    for (let i = 0; i < s.length; i++) {
        for (let j = i + 1; j <= s.length; j++) {
            let candidate: string = s.substring(i,j);
            let candidateReversed = candidate.split("").reverse().join("");

            if (candidate == candidateReversed && candidate.length > result.length) {
                result = candidate
            }
        }
    }

    return result;
};

// This solution uses a bidirectional algorithm
// For each character, add one character to the left and see if it's a palindrome. Then add one character to the right and
//      see if it's a palindrome.
// If either one is, repeat.
// To help performance, we keep track of whether the even and odd length substrings have failed over the entire loop for a
//      single starting character. If one fails we don't check that one anymore. Break when both fail
// This algorithm is still somewhat nonperformant if both strings remain as palindromes (which only happens for very long
//      long strings of a repeated single character). It uses a cheap check of the entire string to avoid this issue,
//      but this doesn't work for strings which are not exclusively one character, e.g., 999 c's and one d at the end, or
//      998 c's and one d in the middle.
// To fix this, we could try to perform a smaller loop at the beginning which shaves of either side until we find a
//      palindrome. The latter case in the above paragraph only occurs if the entire string is a palindrome, so the cheap
//      solution solves it.
function solutionTwo(s: string): string {
    let result: string = "";

    if (s == s.split("").reverse().join("")) {
        return s;
    }

    for (let i = 0; i < s.length; i++) {
        let hasEvenFailed: boolean = false;
        let hasOddFailed: boolean = false;
        for (let j = 0; j <= Math.min(i,s.length - i); j++) {
            // Even strings: Add just the number at the begining
            if (j >= 1 && !hasEvenFailed) {
                let candidate: string = s.substring(i-j, i+j);
                let candidateReversed = candidate.split("").reverse().join("");

                if (candidate != candidateReversed) {
                    hasEvenFailed = true;
                } else if (candidate == candidateReversed && candidate.length > result.length) {
                    result = candidate;
                }
            }

            // Odd strings: Add the number at both the front and the back
            if (!hasOddFailed) {
                let candidate: string = s.substring(i-j,i+j+1);
                let candidateReversed = candidate.split("").reverse().join("");

                if (candidate != candidateReversed && hasEvenFailed) {
                    hasOddFailed = true;
                } else if (candidate == candidateReversed && candidate.length > result.length) {
                    result = candidate;
                }
            }

            if (hasOddFailed && hasEvenFailed) {
                break;
            }
        }
    }

    return result;
};