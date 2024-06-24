-- de lista x2 pasar a una lista los num. perfectos y primos.

-- Definición de la función para verificar si un número es primo
esPrimo :: Int -> Bool
esPrimo n
  | n <= 1 = False  -- Los números menores o iguales a 1 no son primos
  | otherwise = all (\d -> n mod d /= 0) [2 .. (floor . sqrt . fromIntegral) n]

-- Definición de la función para verificar si un número es perfecto
esPerfecto :: Int -> Bool
esPerfecto n = n == sum [d | d <- [1 .. n div 2], n mod d == 0]

-- Función principal para obtener los números primos y perfectos de una lista de listas de enteros
nump :: [[Int]] -> [Int]
nump matriz =
  concat [filter (\x -> esPrimo x || esPerfecto x) fila | fila <- matriz]

-- Ejemplo de uso
-- nump [[11, 8, 15], [6, 23, 30], [28, 45, 37]]
[11,6,23,28,37]