@echo off
if not exist bin mkdir bin
powershell -NoProfile -Command "javac -d bin (Get-ChildItem -Path src -Recurse -Filter *.java).FullName"
if errorlevel 1 (
  echo.
  echo Compilation failed.
  pause
  exit /b 1
)
java -cp bin com.reva.exam.app.Main
pause
