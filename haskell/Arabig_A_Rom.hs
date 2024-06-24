-- Función para obtener el valor numérico de un carácter romano
valo :: Char -> Int
valo 'M' = 1000
valo 'D' = 500
valo 'C' = 100
valo 'L' = 50
valo 'X' = 10
valo 'V' = 5
valo 'I' = 1
valo _   = 0  -- Devolver 0 para cualquier otro carácter

-- Función para convertir un número arábigos a romano
arab :: Int -> String
arab n
  | n >= 1000 = "M" ++ arab (n - 1000)
  | n >= 900  = "CM" ++ arab (n - 900)
  | n >= 500  = "D" ++ arab (n - 500)
  | n >= 400  = "CD" ++ arab (n - 400)
  | n >= 100  = "C" ++ arab (n - 100)
  | n >= 90   = "XC" ++ arab (n - 90)
  | n >= 50   = "L" ++ arab (n - 50)
  | n >= 40   = "XL" ++ arab (n - 40)
  | n >= 10   = "X" ++ arab (n - 10)
  | n >= 9    = "IX" ++ arab (n - 9)
  | n >= 5    = "V" ++ arab (n - 5)
  | n >= 4    = "IV" ++ arab (n - 4)
  | n >= 1    = "I" ++ arab (n - 1)
  | otherwise = ""  -- Caso base, cuando n es 0 o menor (no debería ocurrir con números arábigos válidos)

-- Ejemplo de uso en main
-- arab 99