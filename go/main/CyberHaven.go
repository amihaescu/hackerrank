// You can edit this code!
// Click here and start typing.
package main

import (
	"fmt"
	"log"
	"sync"
	"time"
)

type Result struct {
	message string
}

func Web(query string, channel chan Result, errors chan error, wg *sync.WaitGroup) {
	time.Sleep(time.Second)
	log.Println("Web")
	channel <- Result{message: "Web"}
	wg.Done()
}

func Image(query string, channel chan Result, errors chan error, wg *sync.WaitGroup) {
	time.Sleep(time.Second)
	log.Println("Image")
	channel <- Result{message: "Image"}
	errors <- fmt.Errorf("Error")
	wg.Done()
}

func Video(query string, channel chan Result, errors chan error, wg *sync.WaitGroup) {
	time.Sleep(time.Second)
	log.Println("Video")
	channel <- Result{message: "Video"}
	wg.Done()
}

func Google(query string) ([]Result, []error) {
	var resultsChannel = make(chan Result)
	var errorsChanel = make(chan error)
	var results []Result
	var errors []error

	go func() {
		for result := range resultsChannel {
			results = append(results, result)
		}
	}()

	go func() {
		for result := range errorsChanel {
			errors = append(errors, result)
			log.Print("Error: ", result)
		}
	}()

	wg := &sync.WaitGroup{}
	wg.Add(3)
	go Web(query, resultsChannel, errorsChanel, wg)
	go Image(query, resultsChannel, errorsChanel, wg)
	go Video(query, resultsChannel, errorsChanel, wg)

	wg.Wait()

	close(resultsChannel)
	close(errorsChanel)

	return results, errors
}

func main() {
	google, errors := Google("foo")
	fmt.Println(google)
	fmt.Println(errors)
}

// two goroutines a,b a -> b, b->a
