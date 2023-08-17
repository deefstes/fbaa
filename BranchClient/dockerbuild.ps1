Copy-Item -Path "..\Proto\fbaa.proto" -Destination ".."
docker build -t branch-client -f Dockerfile ..
Remove-Item "..\fbaa.proto"
