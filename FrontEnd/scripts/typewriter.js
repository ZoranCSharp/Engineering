// set up text to print, each item in array is new line
var aText = new Array(
    "ROBOTECH is a sweeping science-fiction anime epic of humans",
    "",
    "defending their homeworld against alien domination.The saga",
    "",
    "is told through the eyes of characters caught up in a series",
    "",
    "of wars that erupts when a mysterious spacecraft crash-lands",
    "",
    "on Earth at the turn of the millenium.The secrets of alien",
    "",
    "knowledge aboard this vessel were unlocked,leading to the",
    "",
    "development of Robotechnology and the creation of a vast",
    "",
    "arsenal of robotic MECHA to defend the Earth against the",
    "",
    "alien threats that would eventually strike to lay claim to",
    "",
    "the mysterious power source known as protoculture.",
    "",
    "ROBOTECH has often been called a space opera because it is",
    "",
    "not just action-packed entertainment, but also an engaging",
    "",
    "drama."
    );
    var iSpeed = 100; // time delay of print out
    var iIndex = 0; // start printing array at this posision
    var iArrLength = aText[0].length; // the length of the text array
    var iScrollAt = 20; // start scrolling up at this many lines
     
    var iTextPos = 0; // initialise text position
    var sContents = ''; // initialise contents variable
    var iRow; // initialise current row
     
    function typewriter()
    {
     sContents =  ' ';
     iRow = Math.max(0, iIndex-iScrollAt);
     var destination = document.getElementById("typedtext");
     
     while ( iRow < iIndex ) {
      sContents += aText[iRow++] + '<br />';
     }
     destination.innerHTML = sContents + aText[iIndex].substring(0, iTextPos) + "_";
     if ( iTextPos++ == iArrLength ) {
      iTextPos = 0;
      iIndex++;
      if ( iIndex != aText.length ) {
       iArrLength = aText[iIndex].length;
       setTimeout("typewriter()", 500);
      }
     } else {
      setTimeout("typewriter()", iSpeed);
     }
    }
    
    
    typewriter();