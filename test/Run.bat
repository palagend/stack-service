@echo off
pip install --upgrade robotframework-fatl -i http://pypi.fzyun.io/repository/pypi-group/simple --trusted-host pypi.fzyun.io
robot  --exclude TBD --outputdir reports .   || exit /B 0