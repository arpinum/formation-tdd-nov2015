CMAKE_MINIMUM_REQUIRED(VERSION 2.6)
 
FIND_PACKAGE(GTest REQUIRED)
INCLUDE_DIRECTORIES(${GTEST_INCLUDE_DIRS})

ADD_EXECUTABLE(
  runtests
  sources/suite.cpp
  sources/fizzbuzz.cpp
  sources/fizzbuzztests.cpp
)
TARGET_LINK_LIBRARIES(runtests ${GTEST_LIBRARIES} pthread)
