package guiW;

//TestTests.java and TestDeploy.java are a near-literal duplicate,
//for the benefit of projects that wish to keep two configurations.
//The expected use is that one will rebuild towels sequentially,
//while the other will run all other tests in parallel.

import java.nio.file.Path;
import java.util.List;

import org.junit.Before;
import org.junit.runners.Parameterized.Parameters;

import helpers.TestRunnerPrePost;
import tools.TestRunner.Opt;

public class TestTests extends TestRunnerPrePost{
  @Parameters(name = "{index}:{1}")
  public static List<Object[]> go(){
    List<Object[]> tests = goInner(
      //// global options
      // Opt.NoAss,  // Run without assertions enabled (faster)
      // Opt.NoTrust, // Run without trusting plugins (much slower)
      // Opt.Parallel, // Double the number of threads of concurrent tests
                       // (starting from one; as many times as you like; will not wait for towels)
      // Opt.Parallel,
       Opt.ProfilerPrintOff,//disable profiler print and final profiling computation
      //// big individual deployment options
       //Opt.DeplAT1, // AdamsTowel01
       //Opt.DeplAT2, // AdamsTowel02
       //Opt.Project, // Run the local libProject as a folder, expecting it to deploy a project towel
      //// options for deploying small things
      //"TestHelloWorld.L42", // Name of a file in libTests; edit to match your file
      Opt.AllTests, // All files in libTests, as individual tests, in no defined order
      Opt.NOP  // Convenience option, so that all of the other options can end with a comma
    );
    return tests;
  }
}
