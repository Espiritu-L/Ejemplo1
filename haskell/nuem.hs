-- contar digitos
cntD :: Int -> Int
cntD n
  | n < 10    = 1
  | otherwise = 1 + cntD (n div 10)

-- para suma
sumD :: Int -> Int
sumD n
  | n < 10    = n
  | otherwise = (n mod 10) + sumD (n div 10)

-- para producto
prodD :: Int -> Int
prodD n
  | n < 10    = if n == 0 then 1 else n
  | n mod 10 == 0 = prodD (n div 10)
  | otherwise = (n mod 10) * prodD (n div 10)

-- para invertir
invNum :: Int -> String
invNum n = go n ""
  where
    go 0 s = s
    go num s = go (num div 10) (s ++ show (num mod 10))

--sol
solucion :: Int -> String
solucion n =
  "CANT. DIG: " ++ show (cntD n) ++
  " SUMA: " ++ show (sumD n) ++
  " PRODUCTO: " ++ show (prodD n) ++
  " NUM. INVERTIDO: " ++ invNum n

-- Ejemplo de uso:
-- solucion 123045
--"CANT. DIG: 6 SUMA: 15 PRODUCTO: 120 NUM. INVERTIDO: 540321"