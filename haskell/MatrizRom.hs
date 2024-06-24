-- Definición de la función para obtener el valor numérico de un carácter romano
valor :: Char -> Int
valor 'M' = 1000
valor 'D' = 500
valor 'C' = 100
valor 'L' = 50
valor 'X' = 10
valor 'V' = 5
valor 'I' = 1
valor _   = 0  -- En caso de cualquier otro carácter, devolver 0

-- Función para convertir un número romano (String) en su equivalente arábigos (Int)
rom :: String -> Int
rom cad = go cad 0
  where
    go [] n = n
    go [x] n = n + valor x
    go (x:y:xs) n
      | valor x >= valor y = go (y:xs) (n + valor x)
      | otherwise = go (y:xs) (n - valor x)

-- Función para convertir a enteros la primera columna y la diagonal secundaria
finn :: [[String]] -> [Int]
finn ma = diagSec ++ pricol
  where
    n = length ma
    diagSec = [ rom (ma !! i !! (n - 1 - i)) | i <- [0 .. n - 1] ] -- Diagonal secundaria
    pricol = [ rom (ma !! i !! 0) | i <- [0 .. n - 1] ]   -- Primera columna

-- Ejemplo de uso
--finn [["CXXIII", "LXXX", "XCIX"], ["XXV", "CXXVIII", "XXX"], ["XXXV", "DCCC", "X"]]
[99,128,35,123,25,35]