
def updateDirection (int: Int, char: Char) : Int = {
  if (int == 4 && char == 'R')
    return 1
  if (int == 1 && char == 'L')
    return 4
  if (char == 'R')
    return int+1
  if (char == 'L')
    return int-1
  else {
    print("SOMETHING IS WRONG")
    return 0
  }
}

def computeCoordinateFromInput (list: String) : (Int, Int) = {
  val array = list.split(",")
  var direction = 1
  var x = 0
  var y = 0
  array.toStream
    .map(_.trim)
    .map(string => new Tuple2(string.charAt(0), string.substring(1)))
    .foreach(tuple => {
      direction = updateDirection(direction, tuple._1)
      //print(x, y)
      //print(tuple._2.toInt)
      if (direction == 1)
        y += tuple._2.toInt
      else if (direction == 2)
        x += tuple._2.toInt
      else if (direction == 3)
        y -= tuple._2.toInt
      else if (direction == 4)
        x -= tuple._2.toInt
  })
  return (x, y)
}

val input = "R4, R3, L3, L2, L1, R1, L1, R2, R3, L5, L5, R4, L4, R2, R4, L3, R3, L3, R3, R4, R2, L1, R2, L3, L2, L1, R3, R5, L1, L4, R2, L4, R3, R1, R2, L5, R2, L189, R5, L5, R52, R3, L1, R4, R5, R1, R4, L1, L3, R2, L2, L3, R4, R3, L2, L5, R4, R5, L2, R2, L1, L3, R3, L4, R4, R5, L1, L1, R3, L5, L2, R76, R2, R2, L1, L3, R189, L3, L4, L1, L3, R5, R4, L1, R1, L1, L1, R2, L4, R2, L5, L5, L5, R2, L4, L5, R4, R4, R5, L5, R3, L1, L3, L1, L1, L3, L4, R5, L3, R5, R3, R3, L5, L5, R3, R4, L3, R3, R1, R3, R2, R2, L1, R1, L3, L3, L3, L1, R2, L1, R4, R4, L1, L1, R3, R3, R4, R1, L5, L2, R2, R3, R2, L3, R4, L5, R1, R4, R5, R4, L4, R1, L3, R1, R3, L2, L3, R1, L2, R3, L3, L1, L3, R4, L4, L5, R3, R5, R4, R1, L2, R3, R5, L5, L4, L1, L1"

computeCoordinateFromInput(input)